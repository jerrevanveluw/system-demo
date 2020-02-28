import { useEffect, useState } from 'react';
import { Listener, todoService, userService } from '../services';
import { Todo } from '../models';
import { User } from '../models';

export const useUsers = () => {
  const [users, setUsers] = useState<User[]>([]);

  useEffect(() => {
    return userService.register(setUsers as Listener);
  }, []);

  return users;
};

export const useToDos = () => {
  const [todos, setTodos] = useState<Todo[]>([]);

  useEffect(() => {
    return todoService.register(setTodos as Listener);
  }, []);

  return todos;
};
