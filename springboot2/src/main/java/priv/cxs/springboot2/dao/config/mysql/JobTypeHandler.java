package priv.cxs.springboot2.dao.config.mysql;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import priv.cxs.springboot2.model.JobType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/6 23:58
 */
@MappedJdbcTypes(value = JdbcType.TINYINT)
@MappedTypes(value = JobType.class)
public class JobTypeHandler extends BaseTypeHandler<JobType> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, JobType parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public JobType getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int code = rs.getInt(columnName);
        return JobType.codeOf(code);
    }

    @Override
    public JobType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int code = rs.getInt(columnIndex);
        return JobType.codeOf(code);
    }

    @Override
    public JobType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int code = cs.getInt(columnIndex);
        return JobType.codeOf(code);
    }
}
