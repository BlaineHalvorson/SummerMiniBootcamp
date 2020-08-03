deleteTask(task: Task): void{
    this.http.delete(API_URL + "/tasks/" + TextTrackList.id)
        .subscribe((response:any) => this.getProjects());
}