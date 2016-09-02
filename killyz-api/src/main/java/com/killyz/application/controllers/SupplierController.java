package com.killyz.application.controllers;

import com.killyz.components.suppliers.SupplierManager;
import com.killyz.models.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierManager supplierManager;

    @Autowired
    public SupplierController(SupplierManager supplierManager) {
        this.supplierManager = supplierManager;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public void newSupplier(@RequestBody Supplier supplier) {
        supplierManager.save(supplier);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Supplier> getAllSuppliers() {
        return supplierManager.getAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteSupplier(@RequestBody Supplier supplier) {
        supplierManager.delete(supplier.get_id());
    }

}
