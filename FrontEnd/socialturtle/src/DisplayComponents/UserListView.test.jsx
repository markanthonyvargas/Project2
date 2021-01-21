import React from 'react'
import {configure, shallow} from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import {Card, Form, Button, InputGroup, ListGroup} from 'react-bootstrap';
import {UserListView} from './UserListView';
import { useSelector, useDispatch} from 'react-redux';


configure({adapter: new Adapter()});

describe("<Header User Testing", ()=>{
    it("Shoudld have this input",() =>{
         const wrapper = shallow(<UserListView/>)

         expect(wrapper.contains(<ListGroup.Item></ListGroup.Item>)).toEqual(true);
    })
 });