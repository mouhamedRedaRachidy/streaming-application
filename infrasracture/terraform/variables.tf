variable "project_name" {
  type    = string
  default = "streaming"
}

variable "environment" {
  type    = string
  default = "dev"
}

variable "aws_region" {
  type    = string
  default = "us-west-1"
}

variable "bucket_name" {
  type = string
}