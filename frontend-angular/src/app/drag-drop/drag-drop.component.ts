import { Component } from '@angular/core';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-drag-drop',
  templateUrl: './drag-drop.component.html',
  styleUrls: ['./drag-drop.component.css']
})
export class DragDropComponent {


  todo = ['Get to work', 'Pick up groceries', 'Go home', 'Fall asleep'];

  done = [ 'Get up', 'Brush teeth', 'Take a shower', 'Check e-mail', 'Walk dog'];

  emp = ['e'];

  empd : dynamicContainer = { list:this.emp, id:'id-3'}

  ContainerList  : dynamicContainer[] = [{ list:this.todo, id:'id-1'}, { list:this.done, id:'id-2'}, { list:this.emp, id:'id-3'}];

  containerListIds = this.ContainerList.map( x => x.id);

  test : string = 'initial comment'


    drop(event: CdkDragDrop<string[]>){
      if (event.previousContainer === event.container){
        moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
      } else {
        transferArrayItem(
          event.previousContainer.data,
          event.container.data,
          event.previousIndex,
          event.currentIndex
        );
      }

    // this.test = event.container.data[event.currentIndex];
  }

  updateTest(newTest : string){
      this.test = newTest;
  }

  addContainer(){
    let id = 'id-' + (this.containerListIds.length+1);
    this.ContainerList.push({list:['hello'], id: id});
    this.containerListIds.push(id);
  }

}

interface dynamicContainer{
  list: string[];
  id: string;
}