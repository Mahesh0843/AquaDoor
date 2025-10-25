package com.example.AquaDoor.service;

import com.example.AquaDoor.entity.Agent;
import com.example.AquaDoor.entity.User;

import java.util.List;

public interface AgentService {

    Agent createAgent(Agent agent);

    Agent getAgentById(Long id);

    List<Agent> getAllAgents();

    Agent updateAgent(Long id, Agent agent);

    void deleteAgentById(Long id);

    void deleteAllAgents();
}
