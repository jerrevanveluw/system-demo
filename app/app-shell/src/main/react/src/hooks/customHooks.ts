import { useEffect, useState } from 'react';
import { userService } from '../services/UserService';
import { Listener } from '../services/AbstractService';
import { ToDo, User } from '../models';
import { toDoService } from '../services/ToDoService';

export const useUsers = () => {
  const [users, setUsers] = useState<User[]>([]);

  useEffect(() => {
    return userService.register(setUsers as Listener);
  }, []);

  return users;

};

export const useToDos = () => {
  const [toDos, setToDos] = useState<ToDo[]>([]);

  useEffect(() => {
    return toDoService.register(setToDos as Listener);
  }, []);

  return toDos;
};