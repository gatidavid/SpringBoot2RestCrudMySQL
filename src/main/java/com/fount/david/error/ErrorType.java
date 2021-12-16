package com.fount.david.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorType {

	private String dateTime;
	private String moduleInfo;
	private String message;
	private String type;
}
