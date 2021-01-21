import React from 'react'
import {configure, shallow} from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import {Card, Form, Button, InputGroup} from 'react-bootstrap';
import UserPosts from './UserPosts';


configure({adapter: new Adapter()});


describe("<Header User Testing", ()=>{
    it("Shoudld have this link",() =>{
         const wrapper = shallow(<UserPosts/>)
         expect(wrapper.contains(<InputGroup.Radio/>)).toEqual(true);
    })
 });