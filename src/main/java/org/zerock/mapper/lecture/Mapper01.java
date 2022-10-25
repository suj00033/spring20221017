package org.zerock.mapper.lecture;

import org.apache.ibatis.annotations.Select;

public interface Mapper01 {
	
	@Select("SELECT NOW()") // 여기서 쿼리문만 잘 작성하면 됨
	public String getCurrentTime();
}
