import React, { Component } from "react";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";

import UserService from "../services/user.service";

const required = value => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};

const name = value => {
  if (value.length < 1 || value.length > 20) {
    return (
      <div className="alert alert-danger" role="alert">
        Restaurant name needed
      </div>
    );
  }
};

const location = value => {
  if (value.length < 1 || value.length > 40) {
    return (
      <div className="alert alert-danger" role="alert">
        Restaurant location needed
      </div>
    );
  }
};

export default class CreateItem extends Component {
  constructor(props) {
    super(props);
    this.handleCreate = this.handleCreate.bind(this);
    this.onChangeLocation = this.onChangeLocation.bind(this);
    this.onChangeName = this.onChangeName.bind(this);

    this.state = { 
      name: "",
      location: "",
      successful: false,
      message: ""
    };
  }

  onChangeName(e) {
    this.setState({
      name: e.target.value
    });
  }

  onChangeLocation(e) {
    this.setState({
      location: e.target.value
    });
  }

  handleCreate(e) {
    e.preventDefault();

    this.setState({
      message: "",
      successful: false
    });

    this.form.validateAll();

    if (this.checkBtn.context._errors.length === 0) {
      
      UserService.createItem(
        this.state.name,
        this.state.location
      ).then(
        response => {
          this.setState({
            message: "Restaurant created successfully",
            successful: true
          });
          console.log(response);
        },
        error => {
          const resMessage =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();

          this.setState({
            successful: false,
            message: resMessage
          });
        }
      )
    }
  }

  render() {
    return (
      <div className="col-md-12">
        <div className="card card-container">          
          <label>Create Restaurant</label>

          <Form
            onSubmit={this.handleCreate}
            ref={c => {
              this.form = c;
            }}
          >
            {!this.state.successful && (
              <div>
                <div className="form-group">
                  <label htmlFor="name">Restaurant name</label>
                  <Input
                    type="text"
                    className="form-control"
                    name="name"
                    value={this.state.name}
                    onChange={this.onChangeName}
                    validations={[required, name]}
                  />
                </div>

                <div className="form-group">
                  <label htmlFor="location">Location</label>
                  <Input
                    type="location"
                    className="form-control"
                    name="location"
                    value={this.state.location}
                    onChange={this.onChangeLocation}
                    validations={[required, location]}
                  />
                </div>

                <div className="form-group">
                  <button className="btn btn-primary btn-block">Create</button>
                </div>
              </div>
            )}

            {this.state.message && (
              <div className="form-group">
                <div
                  className={
                    this.state.successful
                      ? "alert alert-success"
                      : "alert alert-danger"
                  }
                  role="alert"
                >
                  {this.state.message}
                </div>
              </div>
            )}
            <CheckButton
              style={{ display: "none" }}
              ref={c => {
                this.checkBtn = c;
              }}
            />
          </Form>
        </div>
      </div>
    );
  }
}