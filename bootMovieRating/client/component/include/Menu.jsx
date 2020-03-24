import React, { useEffect, useState } from 'react'
import Axios from 'axios'

function Menu() {
return (
        <>
        <div className="collapse navbar-collapse custom-navmenu" id="main-navbar">
    <div className="container py-2 py-md-5">
      <div className="row align-items-start">
        <div className="col-md-2">
          <ul className="custom-menu">
            <li className="active"><a href="index.html">Home</a></li>
            <li><a href="about.html">About Me</a></li>
            <li><a href="services.html">Services</a></li>
            <li><a href="works.html">Works</a></li>
            <li><a href="contact.html">Contact</a></li>
          </ul>
        </div>
        <div className="col-md-6 d-none d-md-block  mr-auto">
          <div className="tweet d-flex">
            <span className="icofont-twitter text-white mt-2 mr-3"></span>
            <div>
              <p><em>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam necessitatibus incidunt ut
                  officiis explicabo inventore. <br /> <a href="#">t.co/v82jsk</a></em></p>
            </div>
          </div>
        </div>
        <div className="col-md-4 d-none d-md-block">
          <h3>Hire Me</h3>
          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam necessitatibus incidunt ut officiis
            explicabo inventore. <br /> <a href="#">myemail@gmail.com</a></p>
        </div>
      </div>

    </div>
  </div>

  <nav className="navbar navbar-light custom-navbar">
    <div className="container">
      <a className="navbar-brand" href="index.html">MyPortfolio.</a>

      <a href="#" className="burger" data-toggle="collapse" data-target="#main-navbar">
        <span></span>
      </a>

    </div>
  </nav>
   </>
    )
}

export default Menu
