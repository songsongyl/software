package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dox.Address;
import org.example.dox.User;
import org.example.repository.AddressRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Transactional
    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(String uid) {
        return userRepository.findById(uid).orElse(null);
    }

    @Transactional
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public User getUser(String account, String password) {
        return userRepository.find(account, password);
    }

    public List<Address> listAddresses(String uid) {
        return addressRepository.findAddresses(uid);
    }

}
