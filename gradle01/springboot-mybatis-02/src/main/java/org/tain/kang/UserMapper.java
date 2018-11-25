package org.tain.kang;

import java.util.List;
import java.util.Map;

public interface UserMapper {

	public List<Map<String, Object>> selectUserList() throws Exception;
}
