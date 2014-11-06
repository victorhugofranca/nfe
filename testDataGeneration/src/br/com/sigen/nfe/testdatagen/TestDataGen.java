package br.com.sigen.nfe.testdatagen;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.postgresql.Driver;

public class TestDataGen {

	public static void main(String[] args) throws SQLException {
		TestDataGen testDataGen = new TestDataGen();
		testDataGen.queryNF();
	}

	public void queryNF() throws SQLException {
		Connection connection = getConnection();

		ResultSet rs = connection.createStatement().executeQuery(
				"select * from fis_nota_fiscal_eletronica_saida");

		JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

		Workbook workbook = null;
		Sheet sheet = null;
		try {
			workbook = Workbook
					.getWorkbook(new File(
							"//Users//victorfranca//desenvolvimento//workspace_nfe//metadata//bd_json.xls"));
			sheet = workbook.getSheet(0);

		} catch (BiffException | IOException e1) {
			e1.printStackTrace();
		}

		while (rs.next()) {

			for (int i = 1; i < sheet.getRows(); i++) {
				String bdColumn = (sheet.getCell(0, i).getContents());
				String jsonAttribute = (sheet.getCell(1, i).getContents());

				String bdValue = rs.getString(bdColumn);
				if (bdValue != null) {
					jsonObjectBuilder.add(jsonAttribute, bdValue);
				}
			}

			String idNotaEletronica = rs.getString("id");
			queryItemNF(idNotaEletronica, jsonObjectBuilder);

			break;
		}

		workbook.close();

		System.out.println(jsonObjectBuilder.build());
	}

	public void queryItemNF(String idNF, JsonObjectBuilder jsonObjectBuilder)
			throws SQLException {

		Connection connection = getConnection();

		ResultSet rs = connection
				.createStatement()
				.executeQuery(
						"select * from fis_item_nota_fiscal_eletronica_saida where fk_nota_fiscal_eletronica_saida = "
								+ idNF);

		Workbook workbook = null;
		Sheet sheet = null;
		try {
			workbook = Workbook
					.getWorkbook(new File(
							"//Users//victorfranca//desenvolvimento//workspace_nfe//metadata//bd_json.xls"));
			sheet = workbook.getSheet(1);

		} catch (BiffException | IOException e1) {
			e1.printStackTrace();
		}

		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

		JsonObjectBuilder itemJsonObjectBuilder = null;

		while (rs.next()) {

			itemJsonObjectBuilder = Json.createObjectBuilder();

			for (int i = 1; i < sheet.getRows(); i++) {
				String bdColumn = (sheet.getCell(0, i).getContents());
				String jsonAttribute = (sheet.getCell(1, i).getContents());

				String bdValue = rs.getString(bdColumn);
				if (bdValue != null) {
					itemJsonObjectBuilder.add(jsonAttribute, bdValue);
				}
			}

			jsonArrayBuilder.add(itemJsonObjectBuilder);
		}

		workbook.close();
		
		jsonObjectBuilder.add("itens", jsonArrayBuilder);
	}

	private Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new Driver());
		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/SIGEN_SAOP_201306",
				"postgres", "postgres");
		return connection;
	}

}
