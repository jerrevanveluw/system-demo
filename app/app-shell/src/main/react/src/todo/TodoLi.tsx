import React from 'react';
import { Todo } from './todo.model';

type ToDoLiProps = {
  todo: Todo;
};

export const TodoLi = ({ todo }: ToDoLiProps) => {
  const { name } = todo;
  return (
    <div key={name}>
      {name ?? 'Someone'} needs to {todo.description} before {todo.due}
    </div>
  );
};
