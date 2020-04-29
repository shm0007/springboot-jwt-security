import React, { Component } from "react";
import AuthService from "../services/auth.service";
import Input from "react-validation/build/input";

export default class CreateItem extends Component {
  constructor(props) {
    super(props);

    this.state = {
      currentUser: AuthService.getCurrentUser()
    };
  }

  render() {
    const { currentUser } = this.state;

    return (
     // <div>
      <div className="container">
        <header className="jumbotron">
          <h3>
            <strong>{currentUser.username}</strong> Profile
          </h3>
        </header>
        <p>
          <strong>Token:</strong>{" "}
          {currentUser.token.substring(0, 20)} ...{" "}
          {currentUser.token.substr(currentUser.token.length - 20)}
        </p>
        <p>
          <strong>Id:</strong>{" "}
          {currentUser.username}
        </p>
        <p>
          <strong>Email:</strong>{" "}
          {currentUser.email}
        </p>
        <strong>Authorities:</strong>
        <ul>
          {currentUser.roles &&
            currentUser.roles.map((role, index) => <li key={index}>{role}</li>)}
        </ul>

        <form>
      <h1>Hello {this.state.username}</h1>
      <p>Enter your name:</p>
      <input
        type='text'
        onChange={this.myChangeHandler}
      />
      </form>
      </div>
      /*
      <div>
        <div className="form-group">
          <label htmlFor="username">Username</label>
          <Input
            type="text"
            className="form-control"
            name="username"
            //value={this.state.name}
            //onChange={this.onChangeUsername}
            //validations={[required, vusername]}
          />
        </div>

        <div className="form-group">
          <label htmlFor="email">Email</label>
          <Input
            type="text"
            className="form-control"
            name="email"
            //value={this.state.email}
            //onChange={this.onChangeEmail}
            //validations={[required, email]}
          />
        </div>

        <div className="form-group">
          <label htmlFor="password">Password</label>
          <Input
            type="password"
            className="form-control"
            name="password"
            //value={this.state.password}
            //onChange={this.onChangePassword}
            //validations={[required, vpassword]}
          />
        </div>

        <div className="form-group">
          <button className="btn btn-primary btn-block">Sign Up</button>
        </div>
      </div>
      </div>
      */  
    );
  }
}