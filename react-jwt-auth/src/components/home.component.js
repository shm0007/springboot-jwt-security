import React, { Component } from "react";

import UserService from "../services/user.service";

export default class Home extends Component {
  constructor(props) {
    super(props);

    this.state = {
      content: [""]
    };
  }

  componentDidMount() {
    UserService.getItemList().then(
      response => {
        console.log("List of item");
        console.log(response.data.content[0]);
        this.setState({
          content: response.data.content
        });
      },
      error => {
        this.setState({
          content:[""]
        });
      }
    );
  }

  render() {
    const listItems = this.state.content.map((item) =>
      <li>{item.name}</li>
    );
    return (
      <div className="container">
        <header className="jumbotron">
          <h3>
            <strong>Restaurant List</strong>
          </h3>
        </header>

        <ul>{listItems}</ul>
      </div>
    );
  }
}