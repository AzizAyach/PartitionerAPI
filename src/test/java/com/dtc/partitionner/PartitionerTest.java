package com.dtc.partitionner;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.ptc.partitionner.Partitioner;

public class PartitionerTest {

	@Test
	public void partitionNegativeSize() {
		List<Integer> list = Arrays.asList(8, 7, 2, 9, 4, 6);
		assertThrows(IllegalArgumentException.class, () -> Partitioner.partition(list, -1));
	}

	@Test
	public void partitionNullList() {
		assertThrows(IllegalArgumentException.class, () -> Partitioner.partition(null, 3));
	}

	@Test
	public void partitionIntegerList() {
		List<Integer> evenList = Arrays.asList(8, 7, 2, 9, 4, 6);
		List<List<Integer>> partition = Partitioner.partition(evenList, 2);
		assertTrue(partition.size() == 3);
		assertTrue(partition.get(0).size() == 2);

		List<Integer> oddList = Arrays.asList(8, 7, 2, 9, 4, 6, 9);
		partition = Partitioner.partition(oddList, 2);
		assertTrue(partition.size() == 4);
		assertTrue(partition.get(0).size() == 2);
		assertTrue(partition.get(3).size() == 1);
	}

	@Test
	public void partitionStringList() {
		List<String> evenList = Arrays.asList("one", "two", "three", "four");
		List<List<String>> partition = Partitioner.partition(evenList, 2);
		assertTrue(partition.size() == 2);
		assertTrue(partition.get(0).size() == 2);

		List<String> oddList = Arrays.asList("one", "two", "three");
		partition = Partitioner.partition(oddList, 2);
		assertTrue(partition.size() == 2);
		assertTrue(partition.get(0).size() == 2);
		assertTrue(partition.get(1).size() == 1);

	}

}
