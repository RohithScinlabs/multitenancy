package com.multitenancy.multitenancy.TenantIdentifierResolver;

import com.multitenancy.multitenancy.Context.TenantContext;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

public class CustomCurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {
    @Override
    public String resolveCurrentTenantIdentifier() {
        String currentSchema = TenantContext.getCurrentSchema();
        if (currentSchema != null) {
            return currentSchema;
        }
        return "default_schema"; // Provide a default schema if needed
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
