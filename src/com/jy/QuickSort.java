package com.jy;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		DataWrap[] dataWraps = new DataWrap[] { new DataWrap(9, ""), new DataWrap(-16, ""), new DataWrap(21, ""),
				new DataWrap(23, ""), new DataWrap(-30, ""), new DataWrap(-49, ""), new DataWrap(21, ""),
				new DataWrap(30, ""), new DataWrap(13, "") };

		System.out.println("排序前：" + Arrays.toString(dataWraps));

		quickSort(dataWraps);

		System.out.println("*********************排序结束*********************");

		System.out.println("排序后（从小到大）：" + Arrays.toString(dataWraps));
	}

	public static void quickSort(DataWrap[] dataWraps) {
		System.out.println("*********************开始排序*********************");
		quickSort(dataWraps, 0, dataWraps.length - 1);
	}

	public static void quickSort(DataWrap[] dataWraps, int start, int end) {
		if (start < end) { // 只有当子序列的元素大于1个时才进行排序，否则结束
			// 默认以为第一个元素作为分界值
			int base = start;
			// 定义从头、尾开始查找的索引
			int i = start;
			int j = end + 1;
			while (i < j) {
				// 从头往尾查找大于分界值的元素索引
				while (dataWraps[base].compareTo(dataWraps[++i]) >= 0 && i < end)
					;
				// 从尾往头查找小于分界值的元素索引
				while (dataWraps[base].compareTo(dataWraps[--j]) <= 0 && j > start)
					;
				if (i < j)
					swap(dataWraps, i, j);
			}
			// 交换后变成真正的分界点
			// 因为默认的分界点选择的是头部，所以这里只能将base和j交换
			swap(dataWraps, base, j);
			// 每一趟后都打印出当前的排序结果
			System.out.println(Arrays.toString(dataWraps));
			// 递归左边、右边的子序列
			quickSort(dataWraps, start, j - 1);
			quickSort(dataWraps, j + 1, end);

		}
	}

	/**
	 * 交换数组中两个元素的值
	 * 
	 * @param dataWraps
	 *            待操作的数组
	 * @param i
	 *            其中一个待交换元素的索引
	 * @param j
	 *            另一个待交换元素的索引
	 */
	public static void swap(DataWrap[] dataWraps, int i, int j) {
		DataWrap temp = dataWraps[i];
		dataWraps[i] = dataWraps[j];
		dataWraps[j] = temp;
	}

}
