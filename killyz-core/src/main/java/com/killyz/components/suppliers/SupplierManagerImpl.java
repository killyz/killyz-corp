package com.killyz.components.suppliers;

import com.killyz.application.service.suppliers.SupplierService;
import com.killyz.components.counters.CounterManager;
import com.killyz.models.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SupplierManagerImpl implements SupplierManager {

    private final String supplierCounterName = "suppliers";
    private final SupplierService supplierService;
    private final CounterManager counterManager;

    @Autowired
    public SupplierManagerImpl(SupplierService supplierService, CounterManager counterManager) {
        this.supplierService = supplierService;
        this.counterManager = counterManager;
    }

    @Override
    public void save(Supplier supplier) {
        if (supplierService.isSupplierExists(supplier.getNickName()))
            throw new RuntimeException("Supplier: " + supplier.getNickName() + " already exists");

        resetCounterIfRequired();
        supplier.set_id(counterManager.getSequence(supplierCounterName));
        supplierService.save(supplier);
    }

    @Override
    public List<Supplier> getAll() {
        return supplierService.getAll();
    }

    @Override
    public void delete(long supplierId) {
        supplierService.delete(supplierId);
    }

    private void resetCounterIfRequired() {
        if (supplierService.getNumberOfSuppliers() == 0)
            counterManager.resetCounter(supplierCounterName);
    }
}
