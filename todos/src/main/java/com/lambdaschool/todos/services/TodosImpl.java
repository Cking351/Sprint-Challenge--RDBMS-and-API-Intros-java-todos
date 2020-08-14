package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodoRepository;
import com.lambdaschool.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public class TodosImpl implements TodosService{

    @Autowired
    TodoRepository todorepos;

    @Autowired
    UserRepository userrepos;

    @Override
    public void markComplete(long todoid) {
        Todos todo = todorepos.findById(todoid)
                .orElseThrow(() -> new EntityNotFoundException("Todo " + todoid + "Not Found!"));
        todo.setCompleted(true);
    }
}
