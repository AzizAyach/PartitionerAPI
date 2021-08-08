package com.ptc.partitionner;

import java.util.ArrayList;
import java.util.List;

public final class Partitioner {

	private Partitioner() {
	}

	/**
	 * Returns a list of elements into a list of chunks of a given size
	 * 
	 * @param list the list to return consecutive sublists of
	 * @param size the desired size of each sublist
	 * @return list of consecutive sublists
	 * @throws IllegalArgumentException if {@code partitionSize} is nopositive or
	 *                                  {@code inputList} empty or null list
	 */
	public static <T> List<List<T>> partition(List<T> inputList, int partitionSize) {
		if (partitionSize <= 0 || (inputList == null || inputList.isEmpty())) {
			throw new IllegalArgumentException();
		}
		List<List<T>> sublist = new ArrayList<List<T>>();
		int listSize = inputList.size();
		for (int i = 0; i < listSize; i += partitionSize) {
			sublist.add(new ArrayList<T>(
					inputList.subList(i, listSize > i + partitionSize ? i + partitionSize : listSize)));
		}
		return sublist;
	}

}
