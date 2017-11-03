"""Return message."""
import logging

logging.basicConfig()
logger = logging.getLogger()
logger.setLevel(logging.INFO)

def lambda_handler(event, context):
    """Lambda handler for getting the hello world message."""

    region = context.invoked_function_arn.split(':')[3]

    logger.info("message: " + "Hello from " + region)
    
    return {
            "message": "Hello from " + region
    }
