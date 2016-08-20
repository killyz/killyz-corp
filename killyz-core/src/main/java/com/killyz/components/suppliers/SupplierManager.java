package com.killyz.components.suppliers;

import com.killyz.models.Supplier;

import java.util.List;

public interface SupplierManager {

    void save(Supplier supplier);
    List<Supplier> getAll();
    void delete(long supplierId);
}
