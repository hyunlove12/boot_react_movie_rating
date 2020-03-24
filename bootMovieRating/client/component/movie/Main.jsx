import React, { useEffect, useState } from 'react'
import Axios from 'axios'
import Menu from "./../include/Menu.jsx"

function LoginPage() {

return (
        <>
            <Menu />
                <main id="main">
                    <div className="site-section pb-0 site-portfolio">                                        
                        <div className="container"> 
                            <div className="row mb-5 align-items-end">
                                <div className="col-md-6" data-aos="fade-up">
                                    <h2>Contact</h2>
                                    <p className="mb-0">Lorem ipsum dolor sit amet consectetur
                                    adipisicing elit. Quisquam necessitatibus incidunt ut officiis
                                    explicabo inventore.</p>
                                </div>                    
                            </div>     
                                               
                            <div className="row">                   
                             
                                <div className="col-md-6 mb-5 mb-md-0" data-aos="fade-up">                    
                                    <form action="forms/contact.php" method="post" role="form" className="php-email-form">                        
                                        <div className="row">
                                            <div className="col-md-6 form-group">
                                                <label htmlFor="name">Name</label> <input type="text" name="name"
                                                className="form-control" id="name" data-rule="minlen:4"
                                                data-msg="Please enter at least 4 chars" />
                                                <div className="validate"></div>
                                            </div>
                                            <div className="col-md-6 form-group">
                                                <label htmlFor="name">Email</label> <input type="email"
                                                className="form-control" name="email" id="email" data-rule="email"
                                                data-msg="Please enter a valid email" />
                                                <div className="validate"></div>
                                            </div>
                                            <div className="col-md-12 form-group">
                                                <label htmlFor="name">Subject</label> <input type="text"
                                                className="form-control" name="subject" id="subject"
                                                data-rule="minlen:4"
                                                data-msg="Please enter at least 8 chars of subject" />
                                                <div className="validate"></div>
                                            </div>
                                            <div className="col-md-12 form-group">
                                                <label htmlFor="name">Message</label>
                                                <textarea className="form-control" name="message" cols="30"
                                                rows="10" data-rule="required"
                                                data-msg="Please write something for us"></textarea>
                                                <div className="validate"></div>
                                            </div>                                 
                                            <div className="col-md-12 mb-3">
                                                <div className="loading">Loading</div>
                                                <div className="error-message"></div>
                                                <div className="sent-message">Your message has been sent. Thank you!</div>
                                            </div>                                        
                                            <div className="col-md-6 form-group">
                                                <input type="submit" className="readmore d-block w-100" value="Send Message" />
                                            </div>
                                        </div>                                
                                    </form>                    
                                </div>
                            
                                <div className="col-md-4 ml-auto order-2" data-aos="fade-up">
                                    <ul className="list-unstyled">
                                        <li className="mb-3"><strong className="d-block mb-1">약관</strong>
                                            <span>회원가입 동의 </span>
                                        </li>						
                                        <li className="mb-3"><strong className="d-block mb-1">문의사항</strong>
                                            <span>youremail@domain.com</span>
                                        </li>
                                    </ul>
                                </div>    
                                                
                            </div>                    
                        </div>                    
                    </div>
                </main>
        </>
       )
}

export default LoginPage
