package com.killyz.application.service.suppliers;

import com.killyz.models.Supplier;

import java.util.List;

public interface SupplierService {

    void save(Supplier supplier);
    List<Supplier> getAll();
    void delete(long supplierId);
    boolean isSupplierExists(String supplierNickName);
}
