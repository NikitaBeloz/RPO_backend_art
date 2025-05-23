import React from 'react';
import { Navbar, Nav } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHome, faUser } from '@fortawesome/free-solid-svg-icons';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';

import Utils from "C:/MyProject/rpo/front/src/utils/Utils";
import BackendService from "C:/MyProject/rpo/front/src/services/BackendService";

class NavigationBarClass extends React.Component {
  constructor(props) {
    super(props);
    this.goHome = this.goHome.bind(this);
    this.logout = this.logout.bind(this);
  }

  goHome() {
    this.props.navigate('/home');
  }


logout() {
    BackendService.logout().then(() => {
        Utils.removeUser();
        this.goHome()
    });
}

  render() {
      let uname = Utils.getUserName();
      return (
          <Navbar bg="light" expand="lg">
              <Navbar.Brand><FontAwesomeIcon icon={faHome} />{' '}My RPO</Navbar.Brand>
              <Navbar.Toggle aria-controls="basic-navbar-nav" />
              <Navbar.Collapse id="basic-navbar-nav">
                  <Nav className="me-auto">
                      <Nav.Link as={Link} to="/home">Home</Nav.Link>
                      <Nav.Link onClick={this.goHome}>Another Home</Nav.Link>
                      <Nav.Link onClick={() =>{ this.props.navigate("/home")}}>Yet Another Home</Nav.Link>
                  </Nav>
                  <Navbar.Text>{uname}</Navbar.Text>
                  { uname &&
                  <Nav.Link onClick={this.logout}><FontAwesomeIcon icon={faUser} fixedWidth />{' '}Выход</Nav.Link>
                  }
                  { !uname &&
                  <Nav.Link as={Link} to="/login"><FontAwesomeIcon icon={faUser} fixedWidth />{' '}Вход</Nav.Link>
                  }
              </Navbar.Collapse>
          </Navbar>
          );
      }
}

const NavigationBar = (props) => {
  const navigate = useNavigate();
  return <NavigationBarClass navigate={navigate} {...props} />;
};

export default NavigationBar;