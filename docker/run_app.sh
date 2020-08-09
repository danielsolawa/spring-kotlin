#!/bin/bash

docker-compose -f docker-compose-sk.yml down

docker-compose -f docker-compose-sk.yml up -d

