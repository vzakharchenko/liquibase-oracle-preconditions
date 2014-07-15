package liquibase.ext.oracle.preconditions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import liquibase.changelog.ChangeSet;
import liquibase.changelog.DatabaseChangeLog;
import liquibase.database.Database;
import liquibase.exception.PreconditionErrorException;
import liquibase.exception.PreconditionFailedException;
import liquibase.exception.ValidationErrors;
import liquibase.exception.Warnings;
import liquibase.precondition.AbstractPrecondition;
import liquibase.precondition.Precondition;

public abstract class OraclePrecondition extends AbstractPrecondition {

	void closeSilently( PreparedStatement ps ) {
		if ( ps != null ) {
			try {
				ps.close();
			} catch ( SQLException e ) {
			}
		}
	}

	void closeSilently( ResultSet rs ) {
		if ( rs != null ) {
			try {
				rs.close();
			} catch ( SQLException e ) {
			}
		}
	}

    @Override
    public String getSerializedObjectNamespace() {
        return GENERIC_CHANGELOG_EXTENSION_NAMESPACE;
    }
}
