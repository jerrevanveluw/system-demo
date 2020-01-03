import { useEffect, useState } from 'react';
import { userService } from '../services/UserService';
import { Listener } from '../services/AbstractService';
import { Todo, User } from '../models';
import { todoService } from '../services/TodoService';

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