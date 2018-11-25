package org.tain.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	public List<UserDto> selectUserList() throws Exception;
}
