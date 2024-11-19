import React from 'react';
import TodoItem from './TodoItem';

const TodoItemList = ({todos, onToggle, onRemove}) => {
    console.log(todos);
    const todoList = todos.map((todo) => (
          <TodoItem
            {...todo}
            onToggle={onToggle}
            onRemove={onRemove}
            id={todo.id}
            key={todo.id}  
          />
        )
    );
    return(
        <div>{todoList}</div>
    )
}

export default TodoItemList;