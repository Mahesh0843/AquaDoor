package com.example.AquaDoor.controller;

import com.example.AquaDoor.entity.Agent;
import com.example.AquaDoor.entity.User;
import com.example.AquaDoor.repo.AgentRepository;
import com.example.AquaDoor.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aquadoor/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @PostMapping
    public ResponseEntity<Agent> createUser(@RequestBody Agent agent) {
        Agent createdAgent = agentService.createAgent(agent);
        return new ResponseEntity<>(createdAgent, HttpStatus.CREATED);
    }

    @GetMapping("/{agentid}")
    public ResponseEntity<Agent> getAgentById(@PathVariable Long agentid) {
        Agent agent = agentService.getAgentById(agentid);
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Agent>> getAllAgents() {
        List<Agent> agents = agentService.getAllAgents();
        return new ResponseEntity<>(agents, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agent> updateAgent(@PathVariable Long id, @RequestBody Agent agent) {
        Agent updatedAgent = agentService.updateAgent(id, agent);
        return new ResponseEntity<>(updatedAgent, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAgentById(@PathVariable Long id) {
        agentService.deleteAgentById(id);
        return new ResponseEntity<>("Agent with id - " + id + " - Deleted Successfully!", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllAgent() {
        agentService.deleteAllAgents();
        return new ResponseEntity<>("All Agents Deleted Successfully!", HttpStatus.OK);
    }
}
