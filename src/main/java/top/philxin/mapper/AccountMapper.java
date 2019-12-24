package top.philxin.mapper;

import org.apache.ibatis.annotations.*;
import top.philxin.bean.Account;
import top.philxin.bean.AccountExample;

import java.util.List;

@Mapper
public interface AccountMapper {
    long countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    @Delete({
            "delete from j18_account_t",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into j18_account_t (id, name, ",
            "money)",
            "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
            "#{money,jdbcType=DOUBLE})"
    })
    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountExample example);

    @Select({
            "select",
            "id, name, money",
            "from j18_account_t",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("top.philxin.mapper.AccountMapper.BaseResultMap")
    Account selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    @Update({
            "update j18_account_t",
            "set name = #{name,jdbcType=VARCHAR},",
            "money = #{money,jdbcType=DOUBLE}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Account record);

    int updateMoneyById(@Param("id") Integer id, @Param("money") double money);
}
