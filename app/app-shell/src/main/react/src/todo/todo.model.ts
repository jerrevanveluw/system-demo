import { Todo as ExternalTodo } from 'graphql-simple-bindings/todo';

export type Todo = {
  description: string;
  due: string;
  name?: string;
};

export const internalize = ({ description, due, name }: ExternalTodo): Todo => ({
  description,
  due,
  name,
});
