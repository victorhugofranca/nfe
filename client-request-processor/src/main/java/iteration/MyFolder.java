package iteration;

import java.util.Queue;

public class MyFolder<T, U> implements Folder<T, U> {

	public U fold(U u, Queue<T> queue, Function2<T, U, U> function) {

		if (u == null || queue == null || function == null)
			throw new IllegalArgumentException();

		while (!queue.isEmpty()) {
			u = function.apply(queue.poll(), u);
		}

		return u;
	}

}