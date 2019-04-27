package com.fym.lta.DTO;

public class RoleDto {

        private String name;
        private String description;
        private int id;
        private String search;
        private RoleScreenDto power;
        
        public RoleDto(){
            super();
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

    public RoleDto(String search) {
        this.search = search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }  
            
}
