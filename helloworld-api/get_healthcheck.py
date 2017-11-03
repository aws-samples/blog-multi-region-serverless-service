"""Return health."""
import logging
import os

logging.basicConfig()
logger = logging.getLogger()
logger.setLevel(logging.INFO)

def lambda_handler(event, context):
    """Lambda handler for getting the health."""

    logger.info("status: " + os.environ['STATUS'])
    
    return {
            "status": os.environ['STATUS']
    }
