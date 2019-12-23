export abstract class Service {

  private path: string;
  private listeners: Listener[] = [];

  protected constructor(path: string) {
    this.path = path;
  }

  trigger(): void {
    fetch(`http://localhost:3000/${this.path}`, { method: 'GET' })
      .then(it => it.json())
      .then(it => it as [])
      .then(log)
      .then(it => this.updateListeners(it));
  }

  register(listener: Listener): () => void {
    this.listeners = [...this.listeners, listener];
    return () => {
      this.listeners = this.listeners.filter(it => it !== listener);
    };
  }

  private updateListeners(data: any) {
    this.listeners.forEach(it => it(data));
  }

}

export type Listener = ([]) => []


function log(stuff: []) {
  console.log(`Fetched: ${JSON.stringify(stuff, null, 2)}`);
  return stuff;
}