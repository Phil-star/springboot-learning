package top.philxin.mapper;

import org.apache.ibatis.annotations.*;
import top.philxin.bean.User;
import top.philxin.bean.UserExample;

import java.util.List;

@Mapper
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    @Delete({
        "delete from j18_user_t",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into j18_user_t (id, username, ",
        "password, hobbies, ",
        "age)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{hobbies,jdbcType=VARCHAR}, ",
        "#{age,jdbcType=INTEGER})"
    })
    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "id, username, password, hobbies, age",
        "from j18_user_t",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("top.philxin.mapper.UserMapper.BaseResultMap")
    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update j18_user_t",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "hobbies = #{hobbies,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}
