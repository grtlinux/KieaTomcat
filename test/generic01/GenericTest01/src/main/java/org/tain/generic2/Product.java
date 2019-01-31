package org.tain.generic2;

import lombok.Data;

@Data
public class Product<T, M> {

	private T kind;
	private M model;
}
