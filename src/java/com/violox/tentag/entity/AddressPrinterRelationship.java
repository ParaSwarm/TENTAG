package com.violox.tentag.entity;

import com.violox.tentag.domain.*;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AddressPrinterRelationship implements Relationship<Printer, Address> {

    @Inject
    private Key<Integer> child_key;
    @Inject
    private AddressRelation parent;
    @Inject
    private PrinterRelation child;

    @Override
    public ArrayList<Printer> getByParent(Address parent) {
        return child.getByAddress(parent);
    }

    @Override
    public Address getByChild(Printer item) {
        child_key.setKey(item.getAddress().getId());
        return parent.get(child_key);
    }
}
