class Program {
    static clubMap = new Map()
    static eventMap = new Map()
    static program = {}
    static currentEvent = {}

    static getClubMap() {
        return this.clubMap
    }

    static getProgram() {
        return this.program
    }

    static getCurrentEvent() {
        return this.currentEvent
    }

    static getEventMap() {
        return this.clubMap
    }
}

export default {
    getClubMap() {
        return Program.clubMap
    },
    addClub( club, id ) {
        Program.clubMap.set( id, club )
    },
    getClub( id ) {
        return Program.clubMap.get( id )
    },
    getEventMap() {
        return Program.eventMap
    },
    addEvent( event, id ) {
        Program.eventMap.set( id, event )
    },
    getEvent( id ) {
        return Program.eventMap.get( id )
    },
    getProgram() {
        return Program.program
    },
    setProgram( program ) {
        Program.program = program
    },
    getCurrentEvent() {
        return Program.currentEvent
    },
    setCurrentEvent( currentEvent ) {
        Program.currentEvent = currentEvent
    }
}