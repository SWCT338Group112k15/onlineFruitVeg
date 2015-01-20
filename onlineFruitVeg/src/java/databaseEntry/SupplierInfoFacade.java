/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseEntry;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dex
 */
@Stateless
public class SupplierInfoFacade extends AbstractFacade<SupplierInfo> {
    @PersistenceContext(unitName = "onlineFruitVegPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SupplierInfoFacade() {
        super(SupplierInfo.class);
    }
    
}
