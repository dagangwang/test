package com.dot.live.utils.valid;

import com.dot.live.utils.valid.exp.ErrorCode;
import com.dot.live.utils.valid.exp.ValidateException;

public class ValidateUtil {

	public static void notNull(Object object) {
		if (object == null) {
			throw new ValidateException(ErrorCode.PARAMETER_NOT_NULL);
		}
	}
}
