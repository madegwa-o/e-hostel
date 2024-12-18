package com.guava.E_HOSTELS.users.tenant;

import com.guava.E_HOSTELS.users.director.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantService {
    @Autowired
    private final TenantRepository tenantRepository;
    private final PasswordEncoder passwordEncoder;

    public TenantService(TenantRepository tenantRepository, PasswordEncoder passwordEncoder) {
        this.tenantRepository = tenantRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Tenant findById(Long tenantId) {
       return tenantRepository.findByTenantId(tenantId);
    }

    public Tenant findByUsername(String userName){
        return tenantRepository.findByUserName(userName);
    }

    public Tenant saveTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    public Tenant findByemail(String email) {
        return tenantRepository.findByemail(email);
    }

    public List<Tenant> fetchAll() {
        return  tenantRepository.findAll();
    }


    public void updateTenant(Long tenantId, Tenant updatedTenant) {
        Tenant tenantToUpdate = tenantRepository.findById(tenantId).orElse(null);
        if (tenantToUpdate != null) {
            if (updatedTenant.getFirstName() != null) {
                tenantToUpdate.setFirstName(updatedTenant.getFirstName());
            }
            if (updatedTenant.getLastName() != null) {
                tenantToUpdate.setLastName(updatedTenant.getLastName());
            }
            if (updatedTenant.getPhoto() != null) {
                tenantToUpdate.setPhoto(updatedTenant.getPhoto());
            }
            if (updatedTenant.getUserName() != null) {
                tenantToUpdate.setUserName(updatedTenant.getUserName());
            }

            if (updatedTenant.getEmail() != null) {
                tenantToUpdate.setEmail(updatedTenant.getEmail());
            }
            if (updatedTenant.getPassword() != null) {
                String password = passwordEncoder.encode(updatedTenant.getPassword());
                tenantToUpdate.setPassword(password);
            }


            tenantRepository.save(tenantToUpdate);

        }
    }
}
