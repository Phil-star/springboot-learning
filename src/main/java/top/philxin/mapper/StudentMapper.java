package top.philxin.mapper;

import org.apache.ibatis.annotations.*;
import top.philxin.bean.Student;
import top.philxin.bean.StudentExample;

import java.util.List;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    @Delete({
        "delete from j18_student_t",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into j18_student_t (id, student_name, ",
        "age, school)",
        "values (#{id,jdbcType=INTEGER}, #{studentName,jdbcType=VARCHAR}, ",
        "#{age,jdbcType=INTEGER}, #{school,jdbcType=VARCHAR})"
    })
    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    @Select({
        "select",
        "id, student_name, age, school",
        "from j18_student_t",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("top.philxin.mapper.StudentMapper.BaseResultMap")
    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    @Update({
        "update j18_student_t",
        "set student_name = #{studentName,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "school = #{school,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Student record);
}
