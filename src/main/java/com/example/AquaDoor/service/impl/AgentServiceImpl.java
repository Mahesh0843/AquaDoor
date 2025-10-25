package com.example.AquaDoor.service.impl;

import com.example.AquaDoor.entity.Agent;
import com.example.AquaDoor.repo.AgentRepository;
import com.example.AquaDoor.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Override
    @Transactional
    public Agent createAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public Agent getAgentById(Long id) {
        return agentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agent not found with id " + id));
    }

    @Override
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    @Override
    @Transactional
    public Agent updateAgent(Long id, Agent updatedAgent) {
        Agent existingAgent = getAgentById(id);

        existingAgent.setFirstName(updatedAgent.getFirstName());
        existingAgent.setLastName(updatedAgent.getLastName());
        existingAgent.setEmail(updatedAgent.getEmail());
        existingAgent.setPassword(updatedAgent.getPassword());
        existingAgent.setPhoneNumber(updatedAgent.getPhoneNumber());
        existingAgent.setCurrentLocation(updatedAgent.getCurrentLocation());
        existingAgent.setCurrentLatitude(updatedAgent.getCurrentLatitude());
        existingAgent.setCurrentLongitude(updatedAgent.getCurrentLongitude());

        return agentRepository.save(existingAgent);
    }

    @Override
    @Transactional
    public void deleteAgentById(Long id) {
        agentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAllAgents() {
        agentRepository.deleteAll();
    }
}
