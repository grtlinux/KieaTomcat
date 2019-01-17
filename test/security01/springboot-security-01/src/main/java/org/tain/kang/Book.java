package org.tain.kang;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {

	private Integer idx;
	private String title;
	private String isbn;
}
